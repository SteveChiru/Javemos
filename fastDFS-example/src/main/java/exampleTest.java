import org.csource.fastdfs.*;

import java.io.FileNotFoundException;

/**
 * @Description:
 */
public class exampleTest {
	public static void main(String[] args) {
		try {
			ClientGlobal.init("D:\\IdeaProjects\\GithubProjects\\Javemos\\fastDFS-example\\src\\main\\resources\\fdfs_client.conf");
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			String[] strings = storageClient.upload_file("C:\\Users\\cqr15\\Desktop\\JG.jpg", "jpg", null);
			for (String string: strings){
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
