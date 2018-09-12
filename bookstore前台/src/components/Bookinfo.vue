<template>
    <div>
        <v-login></v-login>

        <!-- 图标+搜索+购物车 -->
        <v-jumbotron></v-jumbotron>
        <!-- 详细 -->
        <div class="container">
        <div class="row">
            <div class="col">
                <div class="card" style="width: 26rem;">
                    <img class="card-img-top" :src="cover"  alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text">{{bookinfo.summary}}</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <h3>{{bookinfo.name}}</h3>
                <P>{{bookinfo.author}}</P>
                <P>出版社:{{bookinfo.publish}}</P>
                <p>分类:{{bookinfo.kind}}</p>
                <p>单价:{{bookinfo.price}}</p>
                <p>库存:{{bookinfo.storage}}</p>
                <p>销量:{{bookinfo.volume}}</p>
                <div class="form-group">
                  <label for=""></label>
                  <input type="number" v-model="cart.quantity" class="form-control" name="" id="" aria-describedby="emailHelpId" placeholder="">
                  <button type="submit" class="btn btn-primary" v-on:click="addcart">加入购物车</button>
                </div>
            </div>
        </div>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-3">评价</h1>
                <hr class="my-2">
                <p>评分：{{bookinfo.score}}分</p>
            </div>
        </div>
        <div class="container">
            <div v-for="c in bookinfo.commentList" :key="c.index" class="row">
                <div class="col-12">
                    <p>用户: {{c.userId}}</p>
                    <p>时间:{{c.time}}</p>
                    <p>评分:{{c.score}}</p>
                    <p>评价:</p>
                    <p>{{c.content}}</p>
                    <hr>
                </div>
            </div>
        </div>
    </div>
        
    </div>
    
    
</template>

<script>
import LoginVue from './Login.vue';
import JumbotronVue from './Jumbotron.vue';
export default {
    inject:['reload'],
      name:'Bookinfo',
      components:{
        'v-login':LoginVue,
        'v-jumbotron':JumbotronVue
        },
      data(){
        return{
            cart:{
                    userId:'',
                    bookId:'',
                    quantity:1,
                    // price:'',
                    bookName:'',
                    bookCover:''
                },
            bookinfo:{}
        }
      },
      mounted(){
          this.cart.userId=this.$store.getters.user.userid
          this.axios.get(`${this.host}/book/`+this.$route.query.bookid)
            .then((r) => {
                    this.bookinfo=r.data;
                    this.cart.bookId=r.data.id;
                    this.cart.bookName=r.data.name;
                    // this.cart.price = r.data.price;
                    })
                .catch((error) => {
                    console.log(error)
                    });
      },
      computed:{
          cover: function(){
            let cover='';
            cover = "http://localhost:8080"+this.bookinfo.cover
            return cover;
        },
      },
      methods:{
          addcart(){
              
              this.axios.post(`${this.host}/cart/create`,this.cart)
                .then((r) => {
                        console.log(r);
                        this.reload();
                        alert("添加成功")
                        })
                    .catch((error) => {
                        console.log(error)
                        });
          }
      },

      
}
</script>
