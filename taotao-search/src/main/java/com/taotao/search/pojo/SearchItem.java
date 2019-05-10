/**
 * 
 */

package com.taotao.search.pojo;


/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 上午10:53:17 
* 类说明 ：solr索引库类
*/

/** 
* 
*/

public class SearchItem {
	private String id;
	private String title;
	private String sell_point;
	private Long price;
	private String image;
	private String category_name;
	private String item_desc;
	
	/**
	 * @return the image //解决图片显示不出来的问题 导致原因是因为每个商品里都有多个图片，以,号为分割，因此 读取出来的是很多图片路径为一体的字符串，所以才导致读取不出来的
	 */
	public String getImage() {
		if(image!=null&&!image.equals("")) {
			String[] strings=image.split(",");
			return strings[0];		
			}
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the sell_point
	 */
	public String getSell_point() {
		return sell_point;
	}
	/**
	 * @param sell_point the sell_point to set
	 */
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the item_desc
	 */
	public String getItem_desc() {
		return item_desc;
	}
	/**
	 * @param item_desc the item_desc to set
	 */
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
}
