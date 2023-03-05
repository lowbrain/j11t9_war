package com.example;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = { "/response" }, loadOnStartup = 0)
public class ResponseServlet extends HttpServlet {

    private final Logger log = LogManager.getLogger(ResponseServlet.class);

    private final Logger authLog = LogManager.getLogger("authlog");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            
            // パラメータのチェック１
            Optional<String> item1 = Optional.ofNullable(req.getParameter("item1"));
            if (!item1.isPresent()) throw new IllegalArgumentException("item1");

            // パラメータのチェック２
            Optional<String> item2 = Optional.ofNullable(req.getParameter("item2"));
            if (!item2.isPresent()) throw new IllegalArgumentException("item2");

            // テストモードONのときのみ復号化

            // ログ
            authLog.info("item1:" + item1.get() + ", item2:"+ item2.get());

            // リダイレクトURL生成＆リダイレクト
        } catch (Throwable e) {
            log.error("システムエラーが発生しました。", e);
            throw e;
        }
    }
}
