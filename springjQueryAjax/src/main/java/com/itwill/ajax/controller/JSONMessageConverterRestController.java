package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.News;

/* json은 의존성 추가해줘야 함(converter를 추가해주는 것)
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.9.6</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.9.6</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.6</version>
		</dependency>
*/


@RestController
public class JSONMessageConverterRestController {
	
	@RequestMapping(value="newsTitleJson", produces="application/json;charset=utf-8")
	public News newsTitleJSON() {
		return this.getNewsList().get(0);
	}
	
	@RequestMapping(value="newsTitleListJson", produces="application/json;charset=utf-8")
	public List<News> newsTitleListJSON() {
		return this.getNewsList();
	}
	
	
	@RequestMapping(value="08.newsTitlesJSON", produces="application/json;charset=utf-8")
	public Map newsTitlesJSON() {
		List<News> newsList = this.getNewsList();
		HashMap map = new HashMap();
		map.put("count", newsList.size());
		map.put("data", newsList);
		return map;
	}
	
	/*
	{
		"count":9,
		"data": [
					{
						"newsTitle":"참으로 수고 많으셨습니다…",
						"company":"연합뉴스",
						"date":"2020. 10. 16 오후 12:44:38"
					},
					{
						"newsTitle":"IS 60개국 테러 위협 영상 공개…한국도 포함 포토",
						"company":"SBS뉴스",
						"date":"2020. 10. 16 오후 12:44:38"
					}
				]
	}
	*/
	
	private List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...", "연합뉴스", new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토", "SBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차", "KBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정", "TBC뉴스", new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사", "OMY뉴스", new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기", "조선뉴스", new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다", "YTN뉴스", new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년", "CBS뉴스", new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다", "ITWILL뉴스", new Date().toLocaleString()));
		return newsList;
	}
}