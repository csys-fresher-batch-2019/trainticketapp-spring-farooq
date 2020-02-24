package com.chainsys.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

		public static void  WriteToFile(String fileName,String content) throws IOException {
			Path path = Paths.get(fileName);
			byte[] bytes = content.getBytes();
			Files.write(path, bytes);
		}
	}

