# 🧠 GPT Integration Sample (with WebClient)

Spring Boot 기반 프로젝트로, WebClient를 활용해 OpenAI GPT API를 호출하는 기능을 구현한 샘플입니다.

---

## ✅ 프로젝트 개요

- **기술 스택**: Java 17, Spring Boot, WebClient, JUnit
- **API 호출 방식**: `WebClient`를 활용한 비동기 HTTP 요청
- **보안 처리**: `.env` 파일로 OpenAI API Key를 외부 분리하여 보안 강화
- **테스트**: Spring WebTestClient를 활용한 컨트롤러 통합 테스트 구성

---

## 📁 프로젝트 구조

```
src
├── main
│   └── java/com/gpt/
│       ├── controller          # GPT 컨트롤러
│       ├── dto                 # 요청/응답 DTO
│       ├── client              # WebClient 설정
│       └── integration         # 어플리케이션 진입점
└── resources/
    └── application.yml         # 모델 정보 관리
```

---

## 🔑 환경변수 설정

API 키는 `.env` 파일에서 불러옵니다. 아래처럼 `.env` 파일을 만들어주세요:

```env
OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

> ⚠️ `.env` 파일은 `.gitignore`에 포함되어 있어 Git에 올라가지 않습니다.

---

## 🧪 테스트 실행

```bash
./gradlew clean test
```

WebTestClient를 이용해 컨트롤러 단위의 API 호출 응답을 검증합니다.

---

## ✨ 주요 기능

- [x] WebClient 기반 OpenAI GPT API 호출
- [x] 요청/응답 구조 분리
- [x] API Key 외부 관리 (.env)
- [x] 통합 테스트 구성 완료

---

## 👀 향후 계획

- Spring AI로의 리팩토링 예정  
- 대화 히스토리 관리 구조 고도화

---

## 🛡️ 보안 주의사항

- API Key는 `.env`로 외부화되어 있으며, GitHub에 절대 커밋되지 않도록 관리합니다.
- 이미 삭제된 기록도 Git History에서 완전히 제거했습니다 (`git filter-branch` 사용).

---

## 🧑‍💻 개발자

- **Name**: 수진  
- **Repository**: [github.com/SujinHuh](https://github.com/SujinHuh)
