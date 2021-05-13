var app = new Vue({
    el: '#codeompiler',
    data: {
        codeText: '',

        plangID: '',
        plang: [
            { id: '', val: '- 请选择编程语言 -' },
            { id: 'c', val: 'C' },
            { id: 'cpp', val: 'C++' },
            { id: 'java', val: 'Java' },
            { id: 'go', val: 'Go' },
            { id: 'python', val: 'Python' }
        ]
    },
    methods: {
        runCode: function (e) {
            console.log(this.codeText);
            e.preventDefault();
            let param = new FormData();
            param.append("programLanguage", this.plangID);
            param.append("code", this.codeText);

            let config = {
                headers: {
                    "Content-Type": "multipart/form-data;"
                }
            };

            axios.post('http://127.0.0.1:8181/index', param, config).then(function (response) {
                console.log(response);
            }).catch(function (error) {
                console.log(error);
            });
        },

        plangChange: function (e) {
            this.plangID = e.target.value;
            console.log(this.plangID);
        }
    }
});