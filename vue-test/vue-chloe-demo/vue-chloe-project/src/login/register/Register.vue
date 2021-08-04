<template>
  <div>
    <a-form ref="formRef" :model="formState" :rules="rules" :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item name="userName" label="用户名">
        <a-input ref="userName" v-model:value="formState.userName" v-focus placeholder="请输入用户名"/>
      </a-form-item>
      <a-form-item name="passWord" label="密码">
        <a-input-password v-model:value="formState.passWord" placeholder="请输入密码"/>
      </a-form-item>
      <a-form-item name="passwordRepeat" label="再次输入密码">
        <a-input-password v-model:value="formState.passwordRepeat" placeholder="请再次输入密码"/>
      </a-form-item>
    </a-form>

  </div>
</template>

<script>
import {ref, reactive} from 'vue';
import ajaxUtil from "../../util/AjaxUtil.js";
import {message} from 'ant-design-vue';

export default {
  name: "Register",
  props: {
    registerClose: Function,
    changeRegisterLoading: Function,
  },
  setup(props) {
    const formRef = ref();
    const formState = reactive({
      userName: "",
      passWord: "",
      passwordRepeat: "",
    });

    const passwordRepeatValidator = (rule, value) => {
      return new Promise((resolve, reject) => {

        if (!value) {
          reject('请输入再次输入密码!!');
        } else {
          if (formState.passWord === value) {
            resolve();
          } else {
            reject('两次输入的密码不一致!!');
          }
        }
      })
    };

    const rules = {
      userName: [
        {required: true, message: '请输入用户名', trigger: 'blur',},
      ],
      passWord: [
        {required: true, message: '请输入密码', trigger: 'blur'},
      ],
      passwordRepeat: [
        {validator: passwordRepeatValidator, trigger: 'blur'},
      ],
    };

    const resetContext = () => {
      formRef.value.resetFields();
    };

    //userName input的dom
    const userName = ref(null);

    const registerUser = (params) => {
      ajaxUtil.get({
        url: '/login/registerUser',
        params,
        success: (res) => {
          props.changeRegisterLoading(false);
          console.log('Chloe',res)
          if(res.resultCode == 200){
            message.success('注册成功');
            props.registerClose();
          }else{
            message.error(res.resultDesc);
            userName.value.focus();
          }
        },
        error: (error) => {
          message.error('注册失败,' + error + '!!!');
          props.changeRegisterLoading(false);
        }
      })
    };

    const register = () => {
      formRef.value.validate().then(() => {
        props.changeRegisterLoading(true);

        let params = formState;
        registerUser(params);
      }).catch(() => {
      })
    };


    return {
      formRef,
      formState,
      rules,
      labelCol: {span: 8},
      wrapperCol: {span: 24},

      register,
      resetContext,
      userName,
    }
  }
}
</script>

<style scoped>

</style>