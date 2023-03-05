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

@WebServlet(urlPatterns = { "/request" }, loadOnStartup = 0)
public class RequestServlet extends HttpServlet {

    private final Logger log = LogManager.getLogger(RequestServlet.class);

    private boolean isProduction;

    private String requestMessage;

    @Override
    public void init() throws ServletException {
        // 環境モードの判定
        Optional<String> env = Optional.ofNullable(getServletContext().getInitParameter("env"));
        isProduction = env.isPresent() ? env.get().equals("production") : false;

        // 権限要求文字列生成
        this.requestMessage = "リクエスト電文";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // リクエストパラメータの設定
            req.setAttribute("auth_request", requestMessage);

            // 動作モードにより表示画面を切り替え
            if (isProduction) {
                req.getRequestDispatcher("/WEB-INF/jsp/request.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/jsp/stub.jsp").forward(req, resp);
            }
        } catch (Throwable e) {
            log.error("システムエラーが発生しました。", e);
            throw e;
        }
    }
}
