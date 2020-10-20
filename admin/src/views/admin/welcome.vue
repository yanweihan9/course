<template>
    <div>
        <h1>
            你好，欢迎进入控制台!
        </h1>
    </div>
</template>

<script>
    export default {
        name: 'welcome',
        mounted: function() {
            // 页面激活方式一
            // this.$parent.activeSidebar("welcome-sidebar")
        },
        methods: {
        }
    }
</script>