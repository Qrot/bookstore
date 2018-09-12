<template>
    <div>
        <!-- 页头 登录 注册  -->

        <v-login></v-login>
        <!-- 图标+搜索+购物车 -->
        
        <v-jumbotron></v-jumbotron>
      <div class="container">
            <div class="row">
            <!-- 展板 -->
            <div class="col">
                <div style="" id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="../assets/b001.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../assets/b002.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../assets/b003.jpg" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <!-- 组件 -->
            <v-tabs></v-tabs>
            <!-- 排名推荐部分 -->
            <!-- 标签导航 -->
            
            </div>
      </div>
    <div class="jumbotron py-3">
        <h1 class="display-4">分类查看</h1>
        <hr class="my-2">
    </div>

        <div class="container">
        <!-- 分类 -->
        <div class="row">
            <div v-for="c in classes" :key='c' class="col-3">
                <div>
                    <button  v-bind:key="c" v-bind:class="['btn btn-primary btn-block', { active: currentClass === c }]" v-on:click="currentClass = c">{{ c }}</button>
                </div>
                
            </div>
        </div>
        <!-- 分类展示 -->

            <div class="row " v-for="book in bookclass" :key="book.class">
                <div   v-show="currentClass==book.class" v-for="i in book.books" :key="i.name" class="card mt-5 " style="width: 15rem;">
                    <img class="card-img-top" :src="cover+i.cover" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text">{{i.name}}{{i.author}}</p>
                    </div>
                    <button type="button" @click="toinfo(i.id)" class="btn btn-primary">查看</button>
                </div>
            </div>

        <!-- 页码 -->
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#1">1</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#2">2</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#3">3</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
    </div>
    </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex';
import TabsVue from './Tabs.vue';
import LoginVue from './Login.vue';
import JumbotronVue from './Jumbotron.vue';
    export default {
        name:'Home',
        data(){
            return{
                currentClass:'文学',
                bookclass:[
                    {
                        class:'文学',
                        books:[
                            {id:'',price:'',storage:'',volume:'',delete:'',isbn:'',name:'',author:'',kind:'',kind:'',publish:'',publTime:'',cover:'',score:'',summary:'',commentList:[]}
                        ]
                    },
                    {
                        class:'工学',
                        books:[
                            {id:'',price:'',storage:'',volume:'',delete:'',isbn:'',name:'',author:'',kind:'',kind:'',publish:'',publTime:'',cover:'',score:'',summary:'',commentList:[]}
                        ]
                    },
                    {
                        class:'数学科学',
                        books:[
                            {id:'',price:'',storage:'',volume:'',delete:'',isbn:'',name:'',author:'',kind:'',kind:'',publish:'',publTime:'',cover:'',score:'',summary:'',commentList:[]}
                        ]
                    },
                    {
                        class:'其他',
                        books:[
                            {id:'',price:'',storage:'',volume:'',delete:'',isbn:'',name:'',author:'',kind:'',kind:'',publish:'',publTime:'',cover:'',score:'',summary:'',commentList:[]}
                        ]
                    }
                ],
                car:'',
                classes: [
                    '文学',
                    '工学',
                    '数学科学',
                    '其他',
                ],
            }
        },
        components:{
            'v-tabs':TabsVue,
            'v-login':LoginVue,
            'v-jumbotron':JumbotronVue
        },
        mounted(){
            //分类查看
            this.axios.get(`${this.host}/book/kind`, {
                params: {
                    k: "文学",
                    o: 0,
                }
            })
            .then((r) => {
                    // this.bookclass[0].class="文学"
                    this.bookclass[0].books=r.data
                    })
                .catch((error) => {
                    console.log(error)
                    });
            this.axios.get(`${this.host}/book/kind`, {
                params: {
                    k: "工学",
                    o: 0,
                }
            })
            .then((r) => {
                    this.bookclass[1].books=r.data
                    })
                .catch((error) => {
                    console.log(error)
                    });
            this.axios.get(`${this.host}/book/kind`, {
                params: {
                    k: "数学科学",
                    o: 0,
                }
            })
            .then((r) => {
                    this.bookclass[2].books=r.data
                    })
                .catch((error) => {
                    console.log(error)
                    });

        },
        computed:{
          cover: function(){
            let cover='';
            cover = "http://localhost:8080"
            return cover;
            },
        },
        methods:{
            //跳转至详细页面
            // todetail: function(){
            //     this.$router.pus({path:'/detail',query:{bookid:this.bookid}})
            // },
            toinfo: function(id){
                this.$router.push({ path: '/bookinfo', query: { bookid:id }});
            },
            //翻页
            nextpage: function(currentpage){
                this.axios.post("")
                .then((r)=>{
                    this.bookinfosa[currentpage].bookinfos=r
                })
                .catch((error) => console.log(error))
            }
        }
    }
</script>

