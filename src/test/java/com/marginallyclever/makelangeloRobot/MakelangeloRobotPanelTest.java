package com.marginallyclever.makelangeloRobot;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

import com.marginallyclever.makelangelo.Translator;
import com.marginallyclever.makelangeloRobot.generators.ImageGenerator;

public class MakelangeloRobotPanelTest {

	@Test
	public void testNoMissingGeneratorPanels() {
		System.out.println("testNoMissingGeneratorPanels() begin.");
		try {
			System.out.println("Translator.start()...");
			System.out.flush();
			Translator.start();
			System.out.println("loading service...");
			System.out.flush();
			ServiceLoader<ImageGenerator> imageGenerators = ServiceLoader.load(ImageGenerator.class);
			System.out.println("iterating...");
			System.out.flush();
			Iterator<ImageGenerator> ici = imageGenerators.iterator();
			while(ici.hasNext()) {
				ImageGenerator c = ici.next();
				System.out.println("Creating panel for "+c.getName());
				System.out.flush();
				c.getPanel();
			}
		} catch(Exception e) {
			fail("Missing panel!");
		}
		System.out.println("testNoMissingGeneratorPanels() complete.");
	}
}
