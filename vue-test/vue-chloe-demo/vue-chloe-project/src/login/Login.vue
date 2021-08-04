<template>
  <div id="login">
    <div class="login-img">
      <img src="public/login/login-bg.jpg"/>
    </div>
    <div class="login-context">
      <a-card :bordered="true" :hoverable="false" style="width: 300px;height: 330px">
        <template #title>
          <span>欢迎登陆</span>
          <button style="float:right;" @click="registerShow">注册</button>
        </template>
        <a-form ref="formRef" :model="formState" :rules="rules" :label-col="labelCol" :wrapper-col="wrapperCol">
          <a-form-item name="userName">
            <a-input ref="userName" v-model:value="formState.userName" style="width: 250px;" v-icon-input-focus
                     placeholder="请输入用户名"
                     @keyup.enter="nextInput($refs.passWord,'userName')">
              <template #prefix>
                <user-outlined type="user"/>
              </template>
            </a-input>
          </a-form-item>
          <a-form-item name="passWord">
            <a-input-password ref="passWord" v-model:value="formState.passWord" style="width: 250px;"
                              placeholder="请输入密码"
                              @keyup.enter="nextInput($refs.captcha,'passWord')">
              <template #prefix>
                <LockOutlined/>
              </template>
            </a-input-password>
          </a-form-item>
          <a-form-item name="captcha">
            <a-row :span="28">
              <a-col :span="9">
                <a-input ref="captcha" v-model:value="formState.captcha" @keyup.enter="nextInput(null,'captcha')">
                  <template #prefix>
                    <InsuranceOutlined/>
                  </template>
                </a-input>
              </a-col>
              <a-col :span="8">
                <img :src="'data:image/jpeg;base64,'+defaultImg" style="width: 80px;height: 32px"/>
              </a-col>
              <a-col :span="7">
                <a-button @click="getCaptcha">换一张</a-button>
              </a-col>
            </a-row>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="onSubmit" style="width: 250px;background-color: #D96215">登录</a-button>
          </a-form-item>
        </a-form>
      </a-card>
    </div>

    <a-modal v-model:visible="registerAble" title="用户注册" @ok="registerUser" width="350px">
      <Register ref="register" :registerClose="registerClose" :changeRegisterLoading="changeRegisterLoading"/>
      <template #footer>
        <a-button key="back" @click="registerUser">取消</a-button>
        <a-button key="submit" type="primary" :loading="registerLoading" @click="registerUser">注册</a-button>
      </template>
    </a-modal>
  </div>
</template>

<script>
import {ref, reactive, onMounted} from 'vue';
import {useStore} from 'vuex';
import {UserOutlined, LockOutlined, InsuranceOutlined} from '@ant-design/icons-vue';
import ajaxUtil from "@/util/AjaxUtil.js";
import Register from "@/login/register/Register.vue";
import {message} from 'ant-design-vue';
import {useRouter} from 'vue-router';
import Cookies from 'js-cookie';

export default {
  name: "Login",
  components: {
    UserOutlined,
    LockOutlined,
    InsuranceOutlined,
    Register,
  },
  setup() {
    //验证码
    const defaultImg = ref("");

    const captchaCode = ref("");

    /**
     * 获取验证码
     */
    const getCaptcha = () => {
      ajaxUtil.get({
        url: '/login/getCaptcha',
        success: (res) => {
          defaultImg.value = res.data.captcha;
          captchaCode.value = res.data.captchaCode;
        }
      })
    };

    onMounted(() => {
      getCaptcha();
    });

    const formRef = ref();
    let formState = reactive({
      userName: "",
      passWord: "",
      captcha: "",
    });

    const rules = {
      userName: [
        {required: true, message: '请输入用户名', trigger: 'blur',},
      ],
      passWord: [
        {required: true, message: '请输入密码', trigger: 'blur'},
      ],
      captcha: [
        {required: true, message: '请输入验证码', trigger: 'blur'},
      ],
    };


    const nextInput = (refs1, fields) => {
      formRef.value.validateFields(fields).then(() => {
        if (fields === 'captcha') {
          onSubmit();
        } else {
          refs1.focus();
        }
      }).catch((error) => {

      });
    };

    const store = useStore();
    const router = useRouter();

    const onSubmit = () => {
      formRef.value
          .validate()
          .then(() => {
            let params = formState;
            params.captchaCode = captchaCode;
            ajaxUtil.get({
              url: '/login/authLogin',
              params: params,
              success: (res) => {
                if (res.resultCode === 200) {
                  store.commit("setToken", res.data.token);
                  Cookies.set("token", res.data.token, {expires: 1});
                  router.push("/home");
                } else {
                  message.error(res.resultDesc);
                }
              },
              error: (err) => {
                message.error(err)
              }
            })
          })
          .catch((error) => {
            console.log('error', error);
          });
    };

    const register = ref(null);
    const registerAble = ref(false);
    const registerLoading = ref(false);

    const registerShow = () => {
      registerAble.value = true;
      setTimeout(() => {
        register.value.resetContext();
      }, 10);
    };

    const registerClose = () => {
      registerAble.value = false;
      registerLoading.value = false;
    };

    const registerUser = () => {
      register.value.register();
    };

    const changeRegisterLoading = (loading) => {
      registerLoading.value = loading;
    };

    return {
      //参数
      formRef,
      formState,
      labelCol: {span: 4},
      wrapperCol: {span: 28},
      defaultImg,
      rules,
      registerAble,
      registerLoading,
      register,

      //方法
      nextInput,
      onSubmit,
      getCaptcha,
      registerUser,
      registerShow,
      registerClose,
      changeRegisterLoading,
    }
  }
}
</script>

<style scoped>
#login {
  width: 100%;
  height: 100%;
}

.login-img img {
  width: 100%;
  height: 100%; /**宽高100%是为了图片铺满屏幕 */
  z-index: -1;
  position: absolute;
}

.login-context {
  position: absolute;
  top: 150px;
  left: 500px;
}
</style>