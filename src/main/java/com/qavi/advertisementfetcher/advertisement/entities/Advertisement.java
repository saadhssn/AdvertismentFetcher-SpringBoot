package com.qavi.advertisementfetcher.advertisement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private long id;
	    private String title;
	    private String description;
	    private String location;
	    private String category;

	    @ManyToOne
		private User user;

}
