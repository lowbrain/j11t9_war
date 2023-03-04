package com.example;

import java.io.IOException;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            authLog.info("ユーザID 認証データ タイムスタンプ");
        } catch (Throwable e) {
            log.error("システムエラーが発生しました。", e);
            throw e;
        }
    }
}
