package controllers

import (
	"encoding/json"
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

	data := []map[string]string{}

	if err := json.Unmarshal(body, &data); err != nil {
		c.JSON(http.StatusInternalServerError, err.Error())
		return
	}

	c.JSON(200, data)
}
