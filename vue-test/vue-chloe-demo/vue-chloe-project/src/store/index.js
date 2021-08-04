import {createStore} from "vuex";
import user from './modules/user.js'

const store = createStore({
    state:{
    },
    mutations:{},
    actions:{},
    modules:{
        user,
    }
});

export default store;