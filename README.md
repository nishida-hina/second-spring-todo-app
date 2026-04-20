シンプルなToDo管理アプリです。  
ユーザー認証機能とタスク管理機能を実装しています。

---

##  1. 機能概要

### ■ ユーザー機能
- ログイン / ログアウト
- バリデーション（重複メール防止など）
- ログイン失敗時のエラーメッセージ表示

### ■ ToDo管理機能
- タスクの新規登録（タイトル / 詳細）
- タスクの削除
- タスクの完了 / 未完了切替

---

## 2. 技術スタック

- バックエンド：Spring Boot（Java）
- フロントエンド：HTML / CSS / JavaScript
- DB：MySQL（またはH2）
- 認証：Spring Security
- 非同期通信： Ajax

---

## 3. 画面構成

| 画面 | URL | 説明 |
|------|-----|------|
| トップ | `/index` | ログイン前画面 |
| ログイン | `/login` | 認証画面 |
| メイン | `/todo/main` | タスク一覧画面 |

---

## 4. API / URL設計

### ■ ToDo操作

| URL | メソッド | 内容 |
|-----|---------|------|
| `/todo/main` | GET | タスク一覧表示 |
| `/todo/add` | GET | 新規登録フォーム取得（モーダル） |
| `/todo/edit` | GET | 編集フォーム取得（モーダル） |
| `/todo/delete` | GET | 削除確認（モーダル） |
| `/todo/save` | POST | タスク登録・更新 |
| `/todo/remove` | POST | タスク削除 |

### ■ 認証

| URL | メソッド | 内容 |
|-----|---------|------|
| `/login` | POST | ログイン処理 |
| `/logout` | POST | ログアウト |

---

## 5. 非同期処理

- タスク追加 → モーダル送信後、一覧に即時反映
- タスク編集 → 更新後リスト更新
- タスク削除 → 即時削除
- 画面遷移なしで操作可能（UX向上）

---

## 6. DB設計

### ■ usersテーブル

| カラム | 型 | 制約 |
|--------|----|------|
| user_id | INT | PK / AUTO_INCREMENT |
| user_name | VARCHAR(50) | NOT NULL |
| email | VARCHAR(50) | NOT NULL / UNIQUE |
| password | VARCHAR(255) | NOT NULL |

---

### ■ todosテーブル

| カラム | 型 | 説明 |
|--------|----|------|
| task_id | INT | PK |
| user_id | INT | FK |
| title | VARCHAR(20) | タイトル |
| description | VARCHAR(200) | 詳細 |
| status | TINYINT | 0:未完了 / 1:完了 |
| delete_flg | TINYINT | 論理削除 |
| created_at | DATETIME | 作成日時 |
| updated_at | DATETIME | 更新日時 |

---

## 7. 工夫した点

- モーダル + 非同期通信で画面遷移を削減
- 論理削除（deleteFlg）を採用
- バリデーションによる安全なデータ管理
- Spring Securityによる認証実装
- ユーザーごとのタスク管理（user_idで紐付け）

---


## 8. セットアップ方法

```bash
# クローン
git clone https://github.com/yourname/todo-app.git

# ディレクトリ移動
cd todo-app

# 起動
./mvnw spring-boot:run
