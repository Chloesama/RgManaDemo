const user = {
    state: {
        token:"",
    },
    mutations: {
        setToken(store, token) {
            store.token = token;
        },
    },
}

export default user;