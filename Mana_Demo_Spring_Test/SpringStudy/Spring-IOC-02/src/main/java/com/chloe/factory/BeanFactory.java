package com.chloe.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BeanFactroy
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/26 14:08
 * @Version 1.0
 **/
public class BeanFactory {
    /**
     * 工厂类的2个任务
     * <p>
     * 1.加装解析xml,读取xml中的bean信息.通过反射技术实例化bean对象,然后放入map代用
     * 2.提供接口方法根据id从map中获取bean(今天方法)
     */

    private static Map<String, Object> map = new HashMap<>();

    static {
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.selectNodes("//bean");
            //实例化bean对象
            for (int i = 0; i < list.size(); i++) {
                Element element = list.get(i);
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");

                Class<?> aClass = Class.forName(clazz);
                Object o = aClass.newInstance();
                map.put(id, o);
            }

            //维护bean之间的依赖关系
            List<Element> propertyNodes = rootElement.selectNodes("//property");
            for (int i = 0; i < propertyNodes.size(); i++) {
                Element element = propertyNodes.get(i);
                //处理property元素
                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");
                String parentId = element.getParent().attributeValue("id");
                Object parentObject = map.get(parentId);

                Method[] methods = parentObject.getClass().getMethods();
                for (int j = 0; j < methods.length; j++) {
                    Method method = methods[j];
                    if (("set" + name).equalsIgnoreCase(method.getName())) {
                        //bean之间的依赖关系(注入bean)
                        Object propertyObject = map.get(ref);
                        method.invoke(propertyObject);
                    }
                }

                map.put(parentId, parentObject);
            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String id) {
        return map.get(id);
    }

}
