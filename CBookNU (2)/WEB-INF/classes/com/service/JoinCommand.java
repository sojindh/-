package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface JoinCommand {
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws IOException ;
}
