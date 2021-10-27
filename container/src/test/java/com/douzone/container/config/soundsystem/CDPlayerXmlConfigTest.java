package com.douzone.container.config.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.soundsystem.CDPlayer;
import com.douzone.container.soundsystem.CompactDisct;

@RunWith(SpringJUnit4ClassRunner.class) // runner 변경
@ContextConfiguration(locations={"classpath:com/douzone/container/config/soundsystem/CDPlayerConfig.xml"})
public class CDPlayerXmlConfigTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog(); // 화면 출력 내용 비교
	
	@Autowired
	private CDPlayer cdplayer;
	
	@Autowired
	private CompactDisct cd;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdplayer);
	}
	
	@Test
	public void testCompactDiscNotNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testPlay() {
		cdplayer.play();
		assertEquals("Playing 붕붕 by 김하온", systemOutRule.getLog().replace("\r\n", ""));
		
	}
}
