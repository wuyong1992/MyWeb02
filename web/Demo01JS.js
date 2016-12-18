/**
 * Created by wuyong on 2016/12/18.
 */
window.onload = function () {
    /*获取登陆按钮*/
    var loginBtn = document.getElementById("loginBtn");
    loginBtn.onclick = function () {
        /*获取页面的高宽*/
        var sH = document.documentElement.scrollHeight;
        var sW = document.documentElement.scrollWidth;

        /*创建遮罩元素节点*/
        var oMask = document.createElement("div");
        oMask.id = "mask";          //赋予节点id
        oMask.style.height = sH + "px";    //赋予节点属性
        oMask.style.width = sW + "px";

        /*将创建好了的div加入到DOM中去，才能实现效果*/
        document.body.appendChild(oMask);       //加入到了文档的末尾，配合CSS绝对定位

        /*创建登陆框*/
        var login = document.createElement("div");
        login.id = "loginBox";
        /*将该div内部的内容写入*/
        login.innerHTML = "<form action='LoginServlet' method='post'><p>Login</p> <input type='text' name='name' class='name padding' placeholder='name'> <input type='password' name='password' class='password padding' placeholder='password'> <div class='SandR'> <input type='submit' value='登陆' class='sub'> <input type='reset' value='重置' class='res'> </div> </form> <button type='button' id='closeBtn'>关闭</button>";

        /*将创建好了的登陆框加入到DOM中去，才能实现效果*/
        document.body.appendChild(login);

        /*获取loginBox的高宽*/
        var LH = login.offsetHeight;
        var LW = login.offsetWidth;

        /*获取可是页面的高，宽度可以使用页面宽*/
        var wH = document.documentElement.clientHeight;

        /*设这登陆框在页面中的位置，此处为正中央*/
        login.style.left = (sW - LW) / 2 + "px";
        login.style.top = (wH - LH) / 2 + "px";

        /*实现关闭*/
        var close = document.getElementById("closeBtn")     //获取元素
        close.onclick = oMask.onclick = function () {       //点击事件-->删除节点元素
            document.body.removeChild(oMask);
            document.body.removeChild(login);
        };
    };

};