var app = new Vue({
    el: '#codeompiler',
    data: {
        codeText: '#include <iostream> \nusing namespace std; \n\nint main() { \ncout << "Hello cpp!" << endl; \nreturn 0; \n}',

        plangID: 'cpp',
        plang: [
            { id: '', val: '- 请选择编程语言（默认为C++） -' },
            { id: 'c', val: 'C' },
            { id: 'cpp', val: 'C++' },
            { id: 'go', val: 'Golang' },
            { id: 'py', val: 'Python' },
            { id: 'java', val: 'Java' }
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
                let resultText = document.getElementById("res");
                resultText.innerText = response.data;
            }).catch(function (error) {
                console.log(error);
            });
        },

        plangChange: function (e) {
            this.plangID = e.target.value;
            console.log(this.plangID);
            if(this.plangID === 'c'){
                this.codeText = '#include <stdio.h>\n\nint main() { \nprintf("Hello C!"); \nreturn 0; \n}';
            } else if(this.plangID === 'cpp'){
                this.codeText = '#include <iostream> \nusing namespace std; \n\nint main() { \ncout << "Hello cpp!" << endl; \nreturn 0; \n}';
            } else if(this.plangID === 'go'){
                this.codeText = 'package main \nimport  "fmt" \n\nfunc main() { \nfmt.Println("Hello golang!") \n}';
            } else if(this.plangID === 'py'){
                this.codeText = 'print("Hello python!")';
            }else if(this.plangID === 'java'){
                this.codeText = 'public class temp {\npublic static void main(String[] args) {\nSystem.out.println("Hello World");\n}\n}\n';
            }
        }
    }
});