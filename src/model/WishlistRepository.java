package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class WishlistRepository extends Repository {
	public int addWishlist(Wishlist obj) {
		return jdbc.update("CALL AddWishlist(?,?)",obj.getId(),obj.getProductId());
	}
	public  List<Wishlist> getWishlist(String id) {
		return jdbc.query("CALL GetWishlist(?)", new RowMapper<Wishlist>() {

			@Override
			public Wishlist mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Wishlist (rs.getString("WishlistId"),
				rs.getInt("ProductId"),
				rs.getInt("Viewed"),
				rs.getDate("AddedDate"),
				rs.getString("Title"),
				rs.getString("ImageUrl"));
			}
		},id);
	}
}
