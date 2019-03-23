<template>
    <div>
        <router-view></router-view>
    </div>
</template>

<script>
let AAA = {
    template:`aaa`
}
let BBB = {
    template:`bbb`
}
new Vue({
    routes,
    components: {
        AAA,
        BBB
    }    
})
const routes = [
  { path: '/aaa', component: AAA },
  { path: '/bbb', component: BBB }
]
</script>