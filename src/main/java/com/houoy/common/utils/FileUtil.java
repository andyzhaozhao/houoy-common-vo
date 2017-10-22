package com.houoy.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 * 
 * @author andyzhao
 *
 */
public class FileUtil {

	/**
	 * 创建一个新的文件，该文件包含的文件目录也会被同时创建
	 * 
	 * @param fullname
	 *            包含文件路径的文件名称
	 * @return 成功创建地文件
	 */
	public static File createFile(String fullname) {
		File file = new File(fullname);
		createPath(file.getParent());

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return file;
	}

	/**
	 * 创建文件目录
	 * 
	 * @param path
	 *            文件目录
	 */
	public static void createPath(String path) {
		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 文件写入
	 * 
	 * @param file
	 *            文件对象
	 * @param bytes
	 *            写入字节数组
	 */
	public static void writeFile(File file, byte[] bytes) {
		OutputStream writer = null;

		try {
			writer = new BufferedOutputStream(new FileOutputStream(file));
			writer.write(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (null != writer) {
					writer.flush();
					writer.close();
				}
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	/**
	 * 获取文件目录及其子目录下的所有文件
	 * 
	 * @param folder
	 *            文件目录
	 * @return 所有文件列表
	 */
	public static List<File> allFiles(final File folder) {
		List<File> filesList = new ArrayList<File>();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				filesList.addAll(allFiles(fileEntry));
			} else {
				filesList.add(fileEntry);
			}
		}

		return filesList;
	}

	/**
	 * 获取文件目录及其子目录下的符合扩展名过滤的所有文件
	 * 
	 * @param folder
	 *            文件目录
	 * @param extensions
	 *            文件扩展名数组
	 * @return 所有过滤后的文件列表
	 */
	public static List<File> allFiles(final File folder, String... extensions) {
		List<File> filesList = new ArrayList<File>();

		List<File> allFiles = allFiles(folder);
		for (File file : allFiles) {
			// 文件扩展名过滤
			for (String extension : extensions) {
				if (file.getName().toLowerCase().endsWith(extension.toLowerCase().trim())) {
					filesList.add(file);
					break;
				}
			}
		}

		return filesList;
	}

	public static void save(InputStream inputStream, String fileName) {
		OutputStream os = null;
		try {
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件

//            File tempFile = new File(path);
//            if (!tempFile.exists()) {
//                tempFile.mkdirs();
//            }
			os = new FileOutputStream(fileName,true);//采用追加的形式
			// 开始读取
			while ((len = inputStream.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 完毕，关闭所有链接
			try {
				os.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
