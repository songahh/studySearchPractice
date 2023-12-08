package com.example.demo;

import com.example.demo.domain.entity.StudyBoard;
import com.example.demo.domain.entity.StudyBoardHasTag;
import com.example.demo.domain.entity.Tag;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.StudyBoardHasTagRepository;
import com.example.demo.domain.repository.StudyBoardRepository;
import com.example.demo.domain.repository.TagRepository;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.Random;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class HappyStudyApplication {

//	데이터 야매 저장용
//	private final StudyBoardRepository sbr;
//	private final StudyBoardHasTagRepository sbhtr;
//	private final TagRepository tr;
//	private final UserRepository ur;
//
//	@PostConstruct
//	public void save(){
//			User sa = User.builder().id("sa").nickName("송아").img("https://mblogthumb-phinf.pstatic.net/MjAyMDExMjRfMTA3/MDAxNjA2MjA1MDM0Nzkx.DrktdswN2SFmJQEaXdbhl4BnmzlN2oEN03hEHq_UUcQg.MIrlXoSMZsH0pRyuI0x3zIggxc3vlRcb53EYugvLqYkg.JPEG.sosohan_n/IMG_5367.JPG?type=w800").build();
//			User yk = User.builder().id("yk").nickName("유경").img("https://i.pinimg.com/474x/04/43/db/0443db0638cc11ef66913b335ff249cc.jpg").build();
//			User hj = User.builder().id("hj").nickName("현주").img("https://i.pinimg.com/474x/df/3c/4d/df3c4dcf15935d0111426bb28b12d9b1.jpg").build();
//			User mj = User.builder().id("mj").nickName("민지").img("https://i.pinimg.com/736x/19/64/8e/19648ee03da177de2b9735f5aca443a6.jpg").build();
//			ur.save(sa);
//			ur.save(yk);
//			ur.save(hj);
//			ur.save(mj);
//
//			tr.save(Tag.builder().tagName("백엔드").build());
//			tr.save(Tag.builder().tagName("프론트엔드").build());
//			tr.save(Tag.builder().tagName("JAVA").build());
//			tr.save(Tag.builder().tagName("Python").build());
//			tr.save(Tag.builder().tagName("JPA").build());
//			tr.save(Tag.builder().tagName("SpringBoot").build());
//			tr.save(Tag.builder().tagName("SpringSecurity").build());
//			tr.save(Tag.builder().tagName("영어").build());
//			tr.save(Tag.builder().tagName("일본어").build());
//			tr.save(Tag.builder().tagName("중국어").build());
//
//
//			User sa = ur.findById("sa").get();
//			User hj = ur.findById("hj").get();
//			User yk = ur.findById("yk").get();
//			User mj = ur.findById("mj").get();
//
//			Random random = new Random();
//			for(int i=1; i<10; ++i){
//				sbr.save(StudyBoard.builder().user(sa).subject("새 게시글입니다용" + i).content("어질어질").likeCnt(random.nextInt(40)).viewCnt(random.nextInt(40)).open(false).build());
//				sbr.save(StudyBoard.builder().user(yk).subject("스터디 할 사람~~" + i).content("빠샤빠샤").likeCnt(0).viewCnt(0).open(false).build());
//				sbr.save(StudyBoard.builder().user(hj).subject("사람 뽑습니다" + i).content("빠샤빠샤 흐흐흐흐").likeCnt(0).viewCnt(0).open(true).build());
//				sbr.save(StudyBoard.builder().user(mj).subject("모집모집" + i).content("빠샤빠샤 호잇호잇").likeCnt(0).viewCnt(0).open(false).build());
//			}
//
//			for(int i=115; i<125; ++i){
//				sbhtr.save(StudyBoardHasTag.builder().studyBoard(sbr.findById((long)i).get())
//						.tag(tr.findById((long)i%5+1).get()).build());
//				sbhtr.save(StudyBoardHasTag.builder().studyBoard(sbr.findById((long)i).get())
//						.tag(tr.findById((long)i%5+2).get()).build());
//				sbhtr.save(StudyBoardHasTag.builder().studyBoard(sbr.findById((long)i).get())
//						.tag(tr.findById((long)i%5+3).get()).build());
//			}
//
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(HappyStudyApplication.class, args);
	}

}
