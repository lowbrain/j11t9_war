<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isErrorPage="true" session="false" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
  int httpSC = response.getStatus();

  String title = null;
  switch (httpSC) {
    case 400: title = httpSC + " Bad Request";                   break;
    case 401: title = httpSC + " Unauthorized";                  break;
    case 402: title = httpSC + " Payment Required";              break;
    case 403: title = httpSC + " Forbidden";                     break;
    case 404: title = httpSC + " Not Found";                     break;
    case 405: title = httpSC + " Method Not Allowed";            break;
    case 406: title = httpSC + " Not Acceptable";                break;
    case 407: title = httpSC + " Proxy Authentication Required"; break;
    case 408: title = httpSC + " Request Timeout";               break;
    case 409: title = httpSC + " Conflict";                      break;
    case 410: title = httpSC + " Gone";                          break;
    case 411: title = httpSC + " Length Required";               break;
    case 412: title = httpSC + " Precondition Failed";           break;
    case 413: title = httpSC + " Content Too Large";             break;
    case 414: title = httpSC + " URI Too Long";                  break;
    case 415: title = httpSC + " Unsupported Media Type";        break;
    case 416: title = httpSC + " Range Not Satisfiable";         break;
    case 417: title = httpSC + " Expectation Failed";            break;
    case 421: title = httpSC + " Misdirected Request";           break;
    case 422: title = httpSC + " Unprocessable Content";         break;
    case 426: title = httpSC + " Upgrade Required";              break;
    case 500: title = httpSC + " Internal Server Error";         break;
    case 501: title = httpSC + " Not Implemented";               break;
    case 502: title = httpSC + " Bad Gateway";                   break;
    case 503: title = httpSC + " Service Unavailable";           break;
    case 504: title = httpSC + " Gateway Timeout";               break;
    case 505: title = httpSC + " HTTP Version Not Supported";    break;
    default:  title = httpSC + "";                              break;
  }

  String msg  = "エラーが発生しました。アプリケーションを再起動しリトライするか、システム管理者に問い合わせてください。";
  if (400 <= httpSC && httpSC < 500) {
    msg = "サーバへのリクエストが不正です。アプリケーションを再起動しリトライするか、システム管理者に問い合わせてください。";
  } else if (500 <= httpSC && httpSC < 600) {
    msg = "サーバー処理にてシステムエラーが発生しました。アプリケーションを再起動しリトライするか、システム管理者に問い合わせてください。";
  }
%>
<!doctype html>
<html lang="jp" class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>Error Page</title>
  </head>
  <body class="d-flex h-100 text-center">
    <div class="container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="mb-auto">
        <div>
          <h3 class="float-md-start mb-0">エラーページ</h3>
          <span class="float-md-end"><%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) %></span>
        </div>
      </header>
      <main class="px-3">
        <h1><%= title %></h1>
        <p class="lead"><%= msg %></p>
      </main>
      <footer class="mt-auto"></footer>
    </div>
  </body>
</html>