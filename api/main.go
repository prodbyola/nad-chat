package main

import (
	"nadchat/middlewares"

	"github.com/gin-gonic/gin"
	pubctrl "nadchat/public/controllers"
)

func main() {
	router := gin.Default()
	cors := middlewares.Cors()

	router.Use(cors)

	pubctrl.RegisterRoutes(router)

	router.Run(":9000")
}
