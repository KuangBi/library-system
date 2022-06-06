package com.dao;

import com.dto.BookDTO;

import com.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2022-06-01 7:31
 */
public class BookDAO extends BaseDAO<BookDTO> {
    JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDataSource());

    public void addBook(BookDTO book) throws SQLException {
        String sql="insert into book(book_name  ,author ,build_id  ,type  ,introduce ,img_path  ) values(?,?,?,?,?,?)";
        update(sql,book.getBookName(),book.getAuthor(),book.getBuildId(),book.getType(),book.getIntroduce(),book.getImgPath());

    }


    public void updateBook(BookDTO book) throws SQLException {
        String sql="update book set book_name=?,author=?,build_id=?,type=?,introduce=? where id=?";
        update(sql,book.getBookName(),book.getAuthor(),book.getBuildId(),book.getType(),book.getIntroduce(),book.getId());

    }


    public void deleteBook(Integer Id) throws SQLException {
        String sql="delete from book where id=?";
        update(sql,Id);
    }


   /* public List<BookDTO> getBookDTOList() throws SQLException {
        String sql="select id,book_name bookName,author,build_id buildId,type_name typeName,introduce,img_path imgPath from book";
        return getBeanList(BookDTO.class,sql);
    }*/


    /*public BookDTO getBookDTOById(Integer id) throws SQLException {
        String sql="select id,book_name bookName,author,build_id buildId,type_name typeName,introduce,img_path imgPath from book where id=? ";
        return getBean(BookDTO.class,sql,id);
    }*/


    /*public BookDTO getBookDTOByBuildId(Integer BuildId) throws SQLException {
        String sql="select id,book_name bookName,author,build_id buildId,type_name typeName,introduce,img_path imgPath from book where build_id=? ";
        return getBean(BookDTO.class,sql,BuildId);
    }
*/

   /* public BookDTO getBookDTOByTypeName(String typeName) throws SQLException {
        String sql="select id,book_name bookName,author,build_id buildId,type_name typeName,introduce,img_path imgPath from book where type_name=? ";
        return getBean(BookDTO.class,sql,typeName);
    }*/




    /*public BookDTO getBookDTOByName(String bookName) throws SQLException {
        String sql="select id,book_name bookName,author,build_id buildId,type_name typeName,introduce,img_path imgPath from book where book_name=? ";
        return getBean(BookDTO.class,sql,bookName);
    }*/

    public List<BookDTO> pageListByParam(int start, int rows, Map<String, String> paramMap){


        String sql="select id,book_name bookName,author,build_id buildId,type ,introduce ,img_path imgPath from book where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<Object>();
        Set<String> keySet = paramMap.keySet();

        for (String key:keySet){
            sb.append(" and "+key+" like ? ");
            System.out.println(key);
            params.add("%"+paramMap.get(key)+"%");//?是条件的值
            System.out.println(paramMap.get(key));

        }

        sb.append(" limit ?,?");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<BookDTO>(BookDTO.class),params.toArray());

    }
    public int findTotalCountByParam(Map<String, String> paramMap) {
        //定义模板sql
        String sql="select count(*) from book where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<Object>();

        Set<String> keySet = paramMap.keySet();

        for (String key:keySet){
            sb.append(" and "+key+" like ? ");
            params.add("%"+paramMap.get(key)+"%");//?是条件的值

        }

        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

}
