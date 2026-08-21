package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class H11Handler implements HttpHandler {
    private static final String HOME_PAGE = """
            <!doctype html>
            <html lang="en">
              <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>Document</title>
                <style>
                  * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                    font-family: Arial, Helvetica, sans-serif;
                  }
                  body {
                    padding: 50px;
                  }
                  header {
                    background-color: #2c3e50;
                    color: white;
                    padding: 20px;
                    text-align: center;
                  }
                  nav {
                    background-color: #4a6179;
                    padding: 10px;
                    text-align: center;
                  }
                  nav a {
                    text-decoration: none;
                    color: white;
                    margin: 0 15px;
                  }
                  main {
                    display: flex;
                    padding: 20px;
                    min-height: 400px;
                  }
                  section {
                    flex: 3;
                    padding-right: 20px;
                  }
                  aside {
                    flex: 1;
                    background-color: rgb(182, 181, 181);
                    padding: 25px;
                    border-radius: 10px;
                  }
                  article {
                    background-color: #fff;
                    border: 1px solid #ddd;
                    padding: 20px;
                    margin-bottom: 15px;
                    border-radius: 10px;
                  }
            
                  article h3 {
                    color: #2c3e50;
                    padding-bottom: 10px;
                  }
                  footer {
                    background-color: #2c3e50;
                    padding: 15px;
                    text-align: center;
                    color: white;
                  }
                </style>
              </head>
              <body>
                <!-- 페이지 상단 영역 -->
                <header>
                  <h1>📰오늘의 뉴스</h1>
                  <p>매일 새로운 소식을 전합니다</p>
                </header>
                <!-- 내비게이션 메뉴 -->
                <nav>
                  <a href="#">🏠 홈</a>
                  <a href="#">😊 정치</a>
                  <a href="#">🏠 경제</a>
                  <a href="#">🏠 스포츠</a>
                  <a href="#">🏠 과학</a>
                </nav>
                <!-- main: 핵심 콘텐츠 영역 -->
                <main>
                  <section>
                    <h2>오늘의 주요 뉴스</h2>
                    <!-- 독립적인 기사 -->
                    <article>
                      <h3>HTML5 시멘티 태그의 중요성</h3>
                      <p>
                        시멘틱 태그를 사용하면 검색엔진이 더 잘 이해합니다. 또한
                        시각장애인이 사용하는 스크린 리더도 페이지 구조를 파악하기 쉬워
                        집니다
                      </p>
                      <p><small>2026.08.20 | IT/과학</small></p>
                    </article>
            
                    <!-- 독립적인 기사 -->
                    <article>
                      <h3>서울 카페 트랜드</h3>
                      <p>
                        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Error
                        voluptate deleniti non, ab corporis nobis ad placeat eius assumenda
                        impedit sequi animi quibusdam saepe. Error cum maiores sit
                        consequuntur nostrum.
                      </p>
                      <p><small>2026.08.20 | 라이프</small></p>
                    </article>
                  </section>
            
                  <!-- 부가 콘텐츠 영역(사이드바) -->
                  <aside>
                    <h3>인기 검색어</h3>
                    <ol>
                      <li>HTML 시멘틱 태그</li>
                      <li>CSS 레이아웃</li>
                      <li>웹 개발 입문</li>
                      <li>프론트엔드 로드맵</li>
                      <li>자바스크립트 기초</li>
                    </ol>
                  </aside>
                </main>
                <!-- 하단 영역 -->
                <footer>
                  <p>&copy; 2026 오늘의 뉴스. All rights reserved.</p>
                </footer>
              </body>
            </html>
            
            """;
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, HOME_PAGE);
        }
        finally {
            exchange.close();
        }
    }
}
