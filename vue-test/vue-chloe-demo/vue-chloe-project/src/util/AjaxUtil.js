import axios from 'axios';
import store from '../store';

let baseUrl = window.developmentUrl;

let ajaxUtil = {}

ajaxUtil.ajax = (option) => {
    if (!option) {
        console.error("util.ajax cannot do without option");
        return false;
    }

    if (!option.params) {
        option.params = {};
    }

    axios({
        method: option.method,
        baseURL: baseUrl,
        url: option.url,
        data: option.params,
        params: option.params,
    }).then((res) => {
        if (option.success) {
            option.success(res.data);
        }
    }).catch((error) => {
        if (!option.error) {
            option.error(error)
        }
    })
}

ajaxUtil.get = (option) =>{
    if (option) {
        option.method = "get";
        ajaxUtil.ajax(option);
    } else {
        console.error("util.get cannot do without option");
    }
}

ajaxUtil.post = function (option) {
    if (option) {
        option.method = "post";
        ajaxUtil.ajax(option);
    } else {
        console.error("util.post cannot do without option");
    }
}

export default ajaxUtil;