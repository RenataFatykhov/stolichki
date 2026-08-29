<h1 align="center">Автотесты для Tutu.ru</h1>

<h2 align="center">Учебный проект с UI-автотестами для сайта <a href="https://www.tutu.ru/">Tutu.ru</a>. Тесты написаны на Java с использованием Selenide и JUnit 5; результаты формируются в Allure Report.</h2>

<p align="center">
  <a href="https://www.tutu.ru/"><img src="docs/images/tutu-logo.svg" width="100" alt="Логотип Tutu.ru"></a>
</p>

## Схема проекта

```mermaid
flowchart LR
    A[JUnit 5 + Selenide<br/>UI-автотесты] --> B[Jenkins]
    B --> C[Selenoid<br/>Удалённый Chrome]
    B --> D[Allure Report]
    D --> E[Telegram<br/>Уведомление о запуске]
    D --> F[Allure TestOps<br/>Тест-кейсы и запуски]
    F --> G[Jira MUL-45<br/>Связанные тесты и запуски]
```

Тесты организованы по паттерну Page Object: сценарии находятся в `TutuTests`, а действия и проверки страницы - в `pages/TutuMainPage`.

## Технологии

<p align="left">
  <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&amp;logo=openjdk&amp;logoColor=white" alt="Java 21"></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&amp;logo=gradle&amp;logoColor=white" alt="Gradle"></a>
  <a href="https://junit.org/junit5/"><img src="https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&amp;logo=junit5&amp;logoColor=white" alt="JUnit 5"></a>
  <a href="https://selenide.org/"><img src="https://img.shields.io/badge/Selenide-43B02A?style=for-the-badge&amp;logo=selenium&amp;logoColor=white" alt="Selenide"></a>
  <a href="https://allurereport.org/"><img src="https://img.shields.io/badge/Allure_Report-FF6B35?style=for-the-badge&amp;logo=allure&amp;logoColor=white" alt="Allure Report"></a>
  <a href="https://www.jenkins.io/"><img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&amp;logo=jenkins&amp;logoColor=white" alt="Jenkins"></a>
  <a href="https://allurereport.org/allure-testops/"><img src="https://img.shields.io/badge/Allure_TestOps-FF6B35?style=for-the-badge&amp;logo=allure&amp;logoColor=white" alt="Allure TestOps"></a>
  <a href="https://www.atlassian.com/software/jira"><img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&amp;logo=jira&amp;logoColor=white" alt="Jira"></a>
</p>

## Тест-кейсы

| № | Тест-кейс | Что проверяется |
| --- | --- | --- |
| 1 | Открывается главная страница | Адрес соответствует главной странице Tutu.ru |
| 2 | Видна шапка сайта | Отображается видимый экземпляр шапки |
| 3 | Есть meta description | Description содержит ключевую информацию о сервисе |
| 4 | Видно логотип | Отображается логотип со ссылкой на главную страницу |
| 5 | Видна форма поиска | Отображается форма поиска билетов |
| 6 | Есть кнопка «Войти» | Отображается кнопка входа с корректным текстом |
| 7 | Виден футер | После прокрутки отображается футер сайта |
| 8 | Открывается справочная | Открываются URL `/2read/` и страница «Справочная Tutu.ru» |
| 9 | Открывается путеводитель | Открываются URL `/geo/` и страница путеводителя |
| 10 | Открывается страница ЖД-билетов | Открываются URL `/poezda/` и страница с расписанием поездов |

## Особенности реализации

- Для каждого действия в Allure добавлены понятные шаги через `@Step` и `AllureSelenide`.
- Для элементов с несколькими вариантами разметки выбирается видимый экземпляр через `$$().findBy(visible)`.
- URL нормализуются перед сравнением, поэтому двойной слэш после домена не влияет на результат проверки.
- После каждого теста к Allure-отчёту прикладываются скриншот, исходный код страницы, логи браузера и видео запуска.

## Запуск

Локальный запуск:

```bash
./gradlew clean test
```

В Jenkins тесты запускаются в удалённом Chrome через Selenoid. После выполнения Jenkins публикует Allure Report.

## Результаты тестирования

В [прогоне Jenkins №22](https://jenkins.qa.guru/job/tutu/22/allure/#suites/9d9746198fda9b3d1f038c735e93d3e4) успешно выполнены все 10 автотестов.

| Всего тестов | Успешно | Процент прохождения | Длительность |
| --- | --- | --- | --- |
| 10 | 10 | 100 % | 00:01:47 |

### Jenkins

Тесты запускаются в [Jenkins job `tutu`](https://jenkins.qa.guru/job/tutu/). Jenkins собирает проект из GitHub, запускает тесты в Selenoid и публикует артефакты Allure Report и Allure TestOps.

![Успешный запуск Jenkins job](docs/images/jenkins-job.png)

### Allure Report

Allure-отчёт содержит общую статистику, историю запусков, список тестов и детализацию каждого сценария с шагами выполнения и вложениями.

![Сводка Allure Report](docs/images/allure-overview.png)

![Список тестов в Allure Report](docs/images/allure-suites.png)

## Интеграции

### Telegram

После завершения прогона настроено автоматическое Telegram-уведомление: оно содержит круговую диаграмму, число пройденных тестов, длительность и ссылку на Allure Report.

![Результаты тестирования в Telegram](docs/images/telegram-notification.png)

### Allure TestOps

Проект интегрирован с [Allure TestOps](https://allure.qa.guru/project/5371/dashboards). На дашборде заведены 10 активных тест-кейсов, и все 10 отмечены как автоматизированные.

![Дашборд Allure TestOps](docs/images/allure-testops-dashboard.png)

### Jira

Настроена интеграция Jira и Allure TestOps. В [задаче MUL-45](https://jira.qa.guru/browse/MUL-45) отображаются связанные автотесты и результаты их запусков, поэтому статус разработки и результаты тестирования доступны в одной задаче.

## Автор

**Фатыхова Рената Рашидовна**
Auto QA

### Контакты для связи

- Email: [renata.musenova@gmail.com](mailto:renata.musenova@gmail.com)
- Телефон: [+7 917 240-33-84](tel:+79172403384)
