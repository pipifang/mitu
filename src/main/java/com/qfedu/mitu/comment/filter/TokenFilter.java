package com.qfedu.mitu.comment.filter;

        import com.alibaba.fastjson.JSON;
        import com.qfedu.mitu.comment.constant.Constant;
        import com.qfedu.mitu.comment.utils.JedisUtil;
        import com.qfedu.mitu.comment.vo.ResultUtil;
        import org.springframework.beans.factory.annotation.Autowired;
        import javax.servlet.*;
        import javax.servlet.annotation.WebFilter;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;



@WebFilter("/*")
public class TokenFilter implements Filter {
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        JedisUtil jedisUtil = new JedisUtil("www.sueyun.cn", 6379, "298560");
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/api/v1/password")) {
            String email = req.getParameter("email");
            String code = req.getParameter("code");
            String redis = jedisUtil.getStr(email);
            if (redis.equals(code)) {
                chain.doFilter(request, response);
            } else {
                resp.getWriter().print(JSON.toJSONString(ResultUtil.setOtherERROR("验证码不正确")));
                return;
            }
        }
        if (uri.contains("/api/v1/code") || uri.contains("/api/v1/codeLogin") || uri.contains("/api/v1/login") || uri.contains("/api/v1/emaillogin")
        || uri.contains("/api/v1/checkemail")|| uri.contains("/api/v1/message")|| uri.contains("/api/v1/messageLogin")) {
            chain.doFilter(request, response);
        } else {
            String token = req.getHeader("token");

            if (token == null || token == "") {
                resp.getWriter().print(JSON.toJSONString(ResultUtil.setOtherERROR("没有登录")));
                return;
            } else {

                String hashToken = jedisUtil.getHash(Constant.TOKENKEY, token);

                if (hashToken != null) {
                    chain.doFilter(request, response);
                    return;
                }
                String strToken = jedisUtil.getHash(Constant.CODETOKENKEY, "token" + token);
                if (strToken != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }

            resp.getOutputStream().print(JSON.toJSONString(ResultUtil.setOtherERROR("Please Login")));
        }
    }

    @Override
    public void destroy() {

    }
}
