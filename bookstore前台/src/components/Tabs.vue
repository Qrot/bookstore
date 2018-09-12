<template>
    <div class="col-md-12 col-sm-12 col-lg-4">
                <!-- <ul class="nav nav-tabs" id="myTab2" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">销量</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">评分</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="messages-tab" data-toggle="tab" href="#messages" role="tab" aria-controls="messages" aria-selected="false">新品</a>
                    </li>
            
                </ul> -->
                <!-- 实体 -->
                <!-- <div class="tab-content">
                    <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>书名</th>
                                    <th>作者</th>
                                    <th>查看</th>
            
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="i in bookinfo" :key="i.name">
                                    <td>{{i.name}}</td>
                                    <td>{{i.author}}</td>
            
                                    <td>
                                        <a href="详细页面.html">
                                            <button type="button" class="btn btn-primary">查看</button>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>书名</th>
                                    <th>作者</th>
                                    <th>查看</th>
                        
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="i in bookinfo" :key="i.name">
                                    <td>{{i.name}}2</td>
                                    <td>{{i.author}}2</td>
                        
                                    <td>
                                        <a href="详细页面.html">
                                            <button type="button" class="btn btn-primary">查看</button>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>书名</th>
                                    <th>作者</th>
                                    <th>查看</th>
                        
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="i in bookinfo" :key="i.name">
                                    <td>{{i.name}}3</td>
                                    <td>{{i.author}}3</td>
                        
                                    <td>
                                        <a href="详细页面.html">
                                            <button type="button" class="btn btn-primary">查看</button>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div> -->

                <div class="row">
            <div v-for="c in classes" :key='c' class="col">
                <div>
                    <button v-bind:class="['btn btn-primary btn-block', { active: currentClass === c }]" v-on:click="currentClass = c">{{ c }}</button>

                </div>
                
            </div>
        </div>
                <table class="table">
                    <thead>
                        <tr>

                            <th>书名</th>
                            <th>作者</th>
                            <th>价格</th>
                            <th>查看</th>
                        </tr>
                    </thead>
                    <tbody v-if="currentClass==='销量'">
                        <tr v-for="i in bookinfox" :key="i.name">

                            <td>{{i.name}}</td>
                            <td>{{i.author}}</td>
                            <td>{{i.price}}</td>
                            <td>
                                <button type="button" @click="toinfo(i.id)" class="btn btn-primary">查看</button>
                            </td>
                        </tr>
                        
                    </tbody>
                    <tbody v-if="currentClass==='评分'">
                        <tr v-for="i in bookinfox1" :key="i.name">

                            <td>{{i.name}}</td>
                            <td>{{i.author}}</td>
                            <td>{{i.price}}</td>
                            <td>
                                <button type="button" @click="toinfo(i.id)" class="btn btn-primary">查看</button>
                            </td>
                        </tr>
                        
                    </tbody>
                    <tbody v-if="currentClass==='新品'">
                        <tr v-for="i in bookinfox2" :key="i.name">

                            <td>{{i.name}}</td>
                            <td>{{i.author}}</td>
                            <td>{{i.price}}</td>
                            <td>
                                <button type="button" @click="toinfo(i.id)" class="btn btn-primary">查看</button>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
    </div>
</template>
<script>
export default {
    name:'Tabs',
    data(){
        return{
            currentClass:'销量',
            classes:['销量','评分','新品'],
            bookinfox:[

                    {name: '道德经', author: '老子', price: 10.1},
                    { name: '论语', author: '孔子',price: 10.2},
                    { name: '道德经1', author: '老子一', price: 10.1 },
                    { name: '论语1', author: '孔子一', price: 10.2 },
                    { name: '道德经2', author: '老子二', price: 10.1 },

                ],
                bookinfox1:[

                    {name: '道德经3', author: '老子', price: 10.1},
                    { name: '论语3', author: '孔子',price: 10.2},
                    { name: '道德经一', author: '老子一', price: 10.1 },
                    { name: '论语一', author: '孔子一', price: 10.2 },
                    { name: '道德经二1', author: '老子二', price: 10.1 },

                ],
                bookinfox2:[

                    {name: '道德经二', author: '老子', price: 10.1},
                    { name: '论语二', author: '孔子',price: 10.2},
                    { name: '道德经一', author: '老子一', price: 10.1 },
                    { name: '论语一', author: '孔子一', price: 10.2 },
                    { name: '道德经二2', author: '老子二', price: 10.1 },

                ],
        }
    },
    mounted(){
        // 排名
            this.axios.get(`${this.host}/book/score`)
                .then((r) => {
                        this.bookinfox=r.data
                        })
                    .catch((error) => {
                        console.log(error)
                        });
        this.axios.get(`${this.host}/book/volume`)
                .then((r) => {
                        this.bookinfox1=r.data
                        })
                    .catch((error) => {
                        console.log(error)
                        });
        this.axios.get(`${this.host}/book/time`)
                .then((r) => {
                        this.bookinfox2=r.data
                        })
                    .catch((error) => {
                        console.log(error)
                        })
    },
    methods:{
        toinfo: function(id){
                this.$router.push({ path: '/bookinfo', query: { bookid:id }});
            },
    }
}
</script>
