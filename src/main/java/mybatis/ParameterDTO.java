package mybatis;
 
public class ParameterDTO {
	//멤버변수1	
	//사용자 세션 아이디
	private String user_id;
	//게시물의 일련번호
	private String board_idx;	 
	 
	//멤버변수2 : 게시판 Ver02에서 검색기능을 위해 추가한다. 
	//검색필드와 검색어
	private String searchField;  
	private String searchTxt;  
	//게시물의 시작, 종료 구간 설정값
	private int start;		 
	private int end;		 
	//생성자는 추가하지 않고, getter/setter메서드 생성
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(String board_idx) {
		this.board_idx = board_idx;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchTxt() {
		return searchTxt;
	}
	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
