package com.seayon.commons;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/8/1 11:27
 * @Description
 */
public class WondersTools {
	private final static Pattern PATTERN_FOR_TYPE = Pattern.compile("char|int|double");
	private final static Pattern PATTERN_FOR_NAME = Pattern.compile("(?<=\\s)\\w+");
	private final static Pattern PATTERN_FOR_LENGTH = Pattern.compile("(?<=\\[)\\d+(?=\\])");
	private final static Pattern PATTERN_FOR_CNAME = Pattern.compile("(?<=\\*).*?(?=\\*)");
	private final static String PACKAGE_NAME = "package com.wondersgroup.shyb.ydjy.n2l.services.model.cics;";

	public static void main(String[] args) {
		//文件路径，支持目录或指定 .h 文件
		String filePath = "C:\\Users\\15366\\Desktop\\异地门诊\\";
		File file = new File(filePath);
		new WondersTools().buildJavaFileByCheaderFile(file);
	}

	public void buildJavaFileByCheaderFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					buildJavaFileByCheaderFile(f);
				} else {
					doBuildJavaFileByCheaderFile(f);
				}
			}
		} else {
			doBuildJavaFileByCheaderFile(file);
		}
	}

	public  void doBuildJavaFileByCheaderFile(File file) {
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		//判断文件后缀类型
		if (suffix.equals("h") || suffix.equals("H")) {
			SingleFile singleFile = new SingleFile();
			try {
				//以GBK格式来读取文件的每行内容
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
				String s = "";
				//file_index 来记录到达了第几个Body体，第几个struct包裹的结构体
				int file_index = 0;
				while ((s = bufferedReader.readLine()) != null) {
					//遇到一个该字符串开始的说明开始了一个结构体
					if (s.contains("TSTRU_MSG_BODY")) {
						file_index++;
						if (file_index == 1) {
							singleFile.getSingleBody_S().setBodyName(s.substring(s.lastIndexOf("_") + 1));
						} else if (file_index == 3) {
							singleFile.getSingleBody_R().setBodyName(s.substring(s.lastIndexOf("_") + 1));
						}
					} else if (s.contains("}")) {
						//遇到一个结尾花括号说明结束了该结构体
						file_index++;
					}
					//清除一下该字符两边的空格，避免引起其他问题
					s = s.trim();
					String type = CommonUtils.regex(s, PATTERN_FOR_TYPE);
					if (type != null && type.length() > 0) {
						SingleRecord singleRecord = new SingleRecord();
						singleRecord.setType(type);
						String length = CommonUtils.regex(s, PATTERN_FOR_LENGTH);
						singleRecord.setLength(length == null || length.length() == 0 ? "1" : length);
						singleRecord.setName(CommonUtils.regex(s, PATTERN_FOR_NAME));
						singleRecord.setCname(CommonUtils.regex(s, PATTERN_FOR_CNAME));
						if (file_index == 1) {
							System.out.println("file1_line:" + s);
							singleFile.getSingleBody_S().getSingleRecords().add(singleRecord);
						} else if (file_index == 3) {
							System.out.println("file2_line:" + s);
							singleFile.getSingleBody_R().getSingleRecords().add(singleRecord);
						}
					}
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//写入Request类的数据
			doWriteFile(file, singleFile.getSingleBody_S(), "Request");
			doWriteFile(file, singleFile.getSingleBody_R(), "Response");
		} else {
			return;
		}
	}

	private static void doWriteFile(File file, SingleBody singleBody, String type) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getParentFile().getPath() + "/" + singleBody.getBodyName() + "Cics" + type + ".java");

			fileWriter.write(PACKAGE_NAME + "\n\n");
			fileWriter.write("import com.wondersgroup.wsscclib.codec.annotation.CodecProperty;\n" +
					"import com.wondersgroup.wsscclib.codec.annotation.StringProperty;\n" +
					"\n" +
					"/**\n" +
					" * @Version 1.0\n" +
					" * @author: CicsBuilderTool By 赵旭阳\n" +
					" * @Date: " + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()) + "\n" +
					" * @Description： This is a cicsbean automatically generate by CicsBuilderTools\n" +
					" */\n@CodecSupport(encoding = \"GBK\")\n");
			//
			fileWriter.write("public class " + singleBody.getBodyName() + "Cics" + type + " extends MiCommArea {\n ");
			List<SingleRecord> recordList = singleBody.getSingleRecords();
			int startIndex = 20;
			for (SingleRecord singleRecord : recordList) {
				fileWriter.write("\t@CodecProperty(order = " + startIndex + ", cname = \"" + singleRecord.getCname() + "\")\n" +
						"\t@StringProperty(length = " + singleRecord.getLength() + ")\n" +
						"\tprivate String " + singleRecord.getName() + ";\n");
				fileWriter.write("\n");
				startIndex++;
			}

			for (SingleRecord singleRecord : recordList) {
				fileWriter.write("\tpublic String get" + singleRecord.getName() + "() {\n" +
						"\t\treturn " + singleRecord.getName() + ";\n" +
						"\t}\n");
				fileWriter.write("\n");
				fileWriter.write("\tpublic void set" + singleRecord.getName() + "(String " + singleRecord.getName() + ") {\n" +
						"\t\tthis." + singleRecord.getName() + " = " + singleRecord.getName() + ";\n" +
						"\t}\n");
				fileWriter.write("\n");
			}
			fileWriter.write("}\n\n");
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class SingleBody {
		private String bodyName;

		public String getBodyName() {
			return bodyName;
		}

		public void setBodyName(String bodyName) {
			this.bodyName = bodyName;
		}

		private List<SingleRecord> singleRecords = new ArrayList<>();


		public List<SingleRecord> getSingleRecords() {
			return singleRecords;
		}

		public void setSingleRecords(List<SingleRecord> singleRecords) {
			this.singleRecords = singleRecords;
		}
	}

	public class SingleRecord {
		private String type;
		private String name;
		private String length;
		private String cname;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLength() {
			return length;
		}

		public void setLength(String length) {
			this.length = length;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}
	}

	public class SingleFile {
		private SingleBody singleBody_R = new SingleBody();
		private SingleBody singleBody_S = new SingleBody();

		public SingleBody getSingleBody_R() {
			return singleBody_R;
		}

		public void setSingleBody_R(SingleBody singleBody_R) {
			this.singleBody_R = singleBody_R;
		}

		public SingleBody getSingleBody_S() {
			return singleBody_S;
		}

		public void setSingleBody_S(SingleBody singleBody_S) {
			this.singleBody_S = singleBody_S;
		}
	}
}
