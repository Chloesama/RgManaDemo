package com.rgmana.adapter.springmvc;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapterList = new ArrayList<>();

    public DispatchServlet(){
        handlerAdapterList.add(new AnnotationHandlerAdapter());
        handlerAdapterList.add(new HttpHandlerAdapter());
        handlerAdapterList.add(new SimpleHandlerAdapter());
    }

    public void doDispatch(){
        Controller controller = new HttpController();
        HandlerAdapter adapter = getHandler(controller);
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter : this.handlerAdapterList){
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
