package mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
해당 인터페이스는 컨트롤러와 DAO사이세넌 매개역할을 하는 서비스객체로 사용된다. 
@Service 어노테이션은 빈을 자동으로 생성하기 위한 용도이지만 여기서는 단순히
역할을 명시하기 위한 표현으로 사용되었다. 따라서 필수사항은 아니다.
 */
@Service
public interface ServiceMyBoard {
  	
	/*
	방명록 Ver01
	방명록에서 게시물의 갯수를 카운트한다. 매개변수가 없으므로 항상 전체 게시물을
	대상으로 카운트한다. 
	 */
	public int getTotalCount();	
	/*
	매개변수로 전달된 s, e에 해당하는 게시물을 select하여 List형으로 반환한다. 
	 */
	public ArrayList<MyBoardDTO> listPage(int s, int e);
	
	/*
	@Param 어노테이션을 통해 파라미터를 Mapper에서 사용할 수 있는 별칭을 부여한다. 
	해당 별칭으로 쿼리문의 인파라미터로 사용할 수 있다.
	<insert>엘리먼트가 쿼리 실행후 결과값을 정수로 반환하므로 반환타입을 명시하는것이
	좋다. 
	 */
	public int write(@Param("_name") String name, 
			@Param("_contents") String contents,
			@Param("_id") String id);
	
	//기존 게시물의 내용을 읽어온다.
	public MyBoardDTO view(ParameterDTO parameterDTO);

	//수정처리. 커맨드객체인 MyBoardDTO를 매개변수로 전달한다. 
	public int modify(MyBoardDTO myBoardDTO);
	
	//삭제처리. 일련번호와 아이디를 매개변수로 전달한다. 
	public int delete(String idx, String id);	
	
	/*
	방명록 게시판 Ver02
		: 2차 버전에서는 검색기능 추가를 위해 파라미터를 저장한 DTO객체를 매개변수로
		사용한다. Mapper에서 해당 객체를 통해 쿼리문을 구성하게된다.
	 */
	public int getTotalCountSearch(ParameterDTO parameterDTO);
	public ArrayList<MyBoardDTO> listPageSearch(ParameterDTO parameterDTO);
		 
	//Map컬렉션 사용을 위한 추상메서드 선언	
	public ArrayList<MyBoardDTO> hashMapUse(Map<String, String> hMap);
	//List컬렉션 사용을 위한 추상메서드 선언
	public ArrayList<MyBoardDTO> arrayListUse(List<String> aList);	
}

