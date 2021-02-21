package org.zerock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.Store;

import com.google.gson.Gson;

/**
 * Servlet implementation class ApiListController
 */
@WebServlet("/api/list")
public class ApiListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1단계 : 리스트 데이터 넣기 -> json 타입만들기
		List<Store> storeList = new ArrayList<>();
		storeList.add(Store.builder().name("GS25 강남센터점").lat(37.503735).lng(127.024117).build());
		storeList.add(Store.builder().name("CU신논현역점").lat(37.506160).lng(127.024085).build());
		storeList.add(Store.builder().name("세븐일레븐 교보타워사거리점").lat(37.504261).lng(127.022968).build());
		storeList.add(Store.builder().name("GS25 논현드림점").lat(37.505342).lng(127.024872).build());
		storeList.add(Store.builder().name("GS25 논현미래점").lat(37.505475).lng(127.026046).build());
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(storeList);
		System.out.println(jsonStr);
		
		// 2단계 : 브라우저에 보여주는 단계
		// mime 타입을 담는다 -> 지금 내가 보내는 데이터는 json 타입이야라고 알려준다, 한글은 깨지므로 UTF-8 
		response.setContentType("application/json; charset=UTF-8");	
		response.getWriter().println(jsonStr);
		
	}

}
