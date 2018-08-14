package com.sunjine33.swp2;

import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DataSourceTest {

	@Inject
	private DataSource ds;//Connection�� ���� ����Ѵ�

	@Test
	public void test() {
		try (Connection con = ds.getConnection()) {
			System.out.println(con);
			assertNotEquals(0, getAss(con));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final String SelectSQL = "select count(*) from Test";

	private int getAss(Connection con) throws Exception {
		int result = 0;
		try (Statement pstmt = con.createStatement()) {
			ResultSet rs = pstmt.executeQuery(SelectSQL);
			if (rs.next())
				result = rs.getInt(1);
			
			System.out.println(result);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

}