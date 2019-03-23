<template>
    <div>
        <v-app dark>
             <Menu></Menu>
            
            <Footer></Footer>
        </v-app>
       
    </div>
</template>

<script>
import Menu from '../components/Menu'

import Footer from '../components/Footer'

export default {
    components: {
        Menu,
        Footer
    }
}
</script>