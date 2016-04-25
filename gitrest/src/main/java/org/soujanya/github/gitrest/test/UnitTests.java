package org.soujanya.github.gitrest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.soujanya.github.gitrest.resource.BranchResource;

public class UnitTests {
	BranchResource me = new BranchResource();

	@Test
	public void checkRevert() {
		String result = "[ruby_1_3, ruby_1_4, ruby_1_6, ruby_1_8, ruby_1_8_5, ruby_1_8_6, ruby_1_8_7, ruby_1_9_1, ruby_1_9_2, ruby_1_9_3, ruby_2_0_0, ruby_2_1, ruby_2_2, ruby_2_3, trunk, v1_0r, v1_1dev, v1_1r]";
		String methodResult = me.getMessages();

		assertEquals(result, methodResult);
	}
}
