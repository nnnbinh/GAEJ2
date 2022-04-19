package gaej2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaskWorker
 */
@WebServlet(
		name = "TaskWorker",
	    description = "TaskQueues: worker",
	    urlPatterns = "/taskqueues/worker"
)
public class TaskWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TaskWorker.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskWorker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter("key");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		log.info("Thoi diem bat dau: "+sdf.format(date));
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		date= new Date();
		log.info(String.format("Xu ly key '%s' tai thoi diem: %s",key,sdf.format(date)));
	}

}
