package elitecareer.framework.dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import elitecareer.framework.base.PageBase;


public class TestDataProvider extends PageBase{

	@DataProvider(name = "signInPageDataProvider")
	public static Object[][] signInPageData(Method method) throws InvalidFormatException, IOException {
		 
		Object[][] result = null;
 
		if (method.getName().equals("testEmailFieldWithWrongEmail")) {
			result = new Object[][] {
				{ getExcelCellData("SignInPageData.xls", "Sheet1", 1, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet1", 1, 1, "i")},
				{ getExcelCellData("SignInPageData.xls", "Sheet1", 2, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet1", 2, 1, "i") } 
			};
		} else if (method.getName().equals("testEmailFieldWithEmptyEmail")) {
			result = new Object[][] { 
				{ getExcelCellData("SignInPageData.xls", "Sheet1", 1, 1, "i") }, 
				{ getExcelCellData("SignInPageData.xls", "Sheet1", 2, 1, "i") } 
			};
		} else if (method.getName().equals("testPasswordFieldWithWrongPassword")) {
			result = new Object[][] {
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 2, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 2, 1, "s")},
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 3, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 3, 1, "s")},
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 4, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 4, 1, "s")},
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 5, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 5, 1, "s")},
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 6, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 6, 1, "s")} 
			};
		} else if (method.getName().equals("testPasswordFieldWithEmptyPassword")) {
			result = new Object[][] { 
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 2, 0, "s") }, 
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 3, 0, "s") },
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 4, 0, "s") }, 
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 5, 0, "s") }, 
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 6, 0, "s") }
			};
		} else if (method.getName().equals("testSignInWithCorrectCredentials")) {
			result = new Object[][] {
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 12, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 12, 1, "i")},
				{ getExcelCellData("SignInPageData.xls", "Sheet2", 13, 0, "s"), getExcelCellData("SignInPageData.xls", "Sheet2", 13, 1, "i") } 
			};
		}
		return result;
	}
}