var app = new Vue({
    el: '#login',
    data: {
        username: "",

        password: ""
    },
    methods: {
        userLogin: function (e) {
            console.log(this.username);
            console.log(this.password);
            e.preventDefault();
            let param = new FormData();
            param.append("sendUsername", this.username);
            param.append("sendPassword", this.password);

            let config = {
                headers: {
                    "Content-Type": "multipart/form-data;"
                }
            };

            axios.post('http://127.0.0.1:8181', param, config).then(function (response) {
                console.log(response);
            }).catch(function (error) {
                console.log(error);
            });
        }
    }
});