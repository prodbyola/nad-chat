package controllers

import (
	"net/http"
	"os"

	"github.com/gin-gonic/gin"
)

func (h *Handler) CountryCode(c *gin.Context) {
	body, err := os.ReadFile("cc.json")

	if err != nil {
		c.JSON(http.StatusInternalServerError, err.Error())
		return
	}

	c.JSON(200, string(body))
}
