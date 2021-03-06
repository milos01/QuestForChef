package com.packtpub.springmvc.dao;

import java.util.List;

import com.packtpub.springmvc.model.TableOne;
import com.packtpub.springmvc.model.Table_schedule;

public interface Table_scheduleDAO {
	public List<Table_schedule> table_schedule_list(int from, int to, int peopleNum);
	public List<TableOne> allTables(int id);
}
