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

import com.example.zzz.Config;

import static com.example.Constant.*;

@WebServlet(urlPatterns = { "/request" }, loadOnStartup = 0)
public class RequestServlet extends HttpServlet {

    private final Logger log = LogManager.getLogger(RequestServlet.class);

    private boolean isProduction;

    private String requestMessage;

    @Override
    public void init() throws ServletException {
        // 環境モードの判定
        Optional<String> env = Optional.ofNullable(getServletContext().getInitParameter(CTX_PRM_ENV));
        isProduction = env.isPresent() ? env.get().equals("production") : false;

        // リクエスト電文の生成
        this.requestMessage = "リクエスト電文";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // リクエストパラメータの設定
            req.setAttribute(AUTH_REQUEST, requestMessage);

            log.trace("msg");
            log.debug("msg");
            log.info("msg");
            log.warn("msg");
            log.error("msg");

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
