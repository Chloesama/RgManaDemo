import axios from "axios";

export default function ajax(url = '', params = {}, type = 'GET') {
    return new Promise(((resolve, reject) => {
        let promise;

        if (type.toUpperCase() === 'GET') {
            promise = axios({
                url,
                params,
            })
        } else if (type.toUpperCase() === 'POST') {
            promise = axios({
                method: 'post',
                url,
                data: params,
            })
        }

        promise.then((res) => {
            resolve(res);
        }).catch((err) => {
            reject(err);
        })
    }))
}