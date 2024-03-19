package controllers

import "github.com/gin-gonic/gin"

type Handler struct {}

func RegisterRoutes(r *gin.Engine) {
	h := Handler{}

	public := r.Group("/public")

	public.GET("/country-codes", h.CountryCode)
}
