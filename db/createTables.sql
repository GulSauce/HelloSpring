-----------------------------
-- Local MariaDB에 테이블 생성
-----------------------------

CREATE DATABASE SwMaestro DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE SwMaestro;

CREATE TABLE member (
	id VARCHAR(16) NOT NULL COMMENT '회원 아이디',
    password VARCHAR(128) NOT NULL COMMENT '비밀번호 (SHA-512 암호화)',
    name VARCHAR(64) DEFAULT '' COMMENT '이름',
    email VARCHAR(128) DEFAULT '' COMMENT '이메일',
    phone VARCHAR(64) DEFAULT '' COMMENT '전화번호',
    used CHAR(1) DEFAULT 'Y' COMMENT '사용 여부',
    creator VARCHAR(16) NOT NULL COMMENT '최초 등록자 아이디',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP() COMMENT '최초 등록 일시',
    updater VARCHAR(16) NOT NULL COMMENT '최종 수정자 아이디',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '최종 수정 일시',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원 정보 M';

-- INDEX 생성


CREATE TABLE notice (
	id INT NOT NULL AUTO_INCREMENT COMMENT '공지사항 아이디',
    subject VARCHAR(255) NOT NULL COMMENT '제목',
    member_id VARCHAR(16) NOT NULL COMMENT '작성자 아이디',
    content TEXT DEFAULT '' COMMENT '본문',
    used CHAR(1) DEFAULT 'Y' COMMENT '사용 여부',
    creator VARCHAR(16) NOT NULL COMMENT '최초 등록자 아이디',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP() COMMENT '최초 등록 일시',
    updater VARCHAR(16) NOT NULL COMMENT '최종 수정자 아이디',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '최종 수정 일시',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공지사항 M';

-- INDEX 생성

CREATE TABLE notice_file (
    id INT NOT NULL AUTO_INCREMENT COMMENT '공지사항 아이디',
    file_name VARCHAR(127) COMMENT '업로드 한 파일명',
    file_path VARCHAR(255) COMMENT '업로드 한 파일이 저장된 서버 경로',
    used CHAR(1) DEFAULT 'Y' COMMENT '사용 여부',
    creator VARCHAR(16) NOT NULL COMMENT '최초 등록자 아이디',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP() COMMENT '최초 등록 일시',
    updater VARCHAR(16) NOT NULL COMMENT '최종 수정자 아이디',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '최종 수정 일시',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공지사항 파일 M';

-- INDEX 생성
